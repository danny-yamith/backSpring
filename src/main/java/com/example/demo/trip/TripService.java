package com.example.demo.trip;

import com.example.demo.datasource.Datasource;
import com.example.demo.datasource.DatasourceService;
import com.example.demo.path.Path;
import com.example.demo.path.PathService;
import com.example.demo.region.Region;
import com.example.demo.region.RegionService;
import com.example.demo.utils.TripRegionDto;
import com.example.demo.utils.TripWeeklyDto;
import org.hibernate.query.NativeQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.*;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

@Service
public class TripService {
    private static final String SEPARATOR = ",";
    private static final SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    private final TripRepository tripRepository;
    private final DatasourceService datasourceService;
    private final PathService pathService;
    private final RegionService regionService;

    @Autowired
    public TripService(TripRepository tripRepository, DatasourceService datasourceService, PathService pathService, RegionService regionService) {
        this.tripRepository = tripRepository;
        this.datasourceService = datasourceService;
        this.pathService = pathService;
        this.regionService = regionService;
    }

    public List<Trip> getTrips() {
        return tripRepository.findAll();
    }

    public Trip getTripById(Integer id) {
        Trip trip = tripRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException(
                        "trip with id " + id + "does not exist"));
        return trip;
    }

    public Trip addNewTrip(Trip trip) {
        tripRepository.save(trip);
        return trip;
    }

    public String processFile(MultipartFile multipartFile) throws Exception {
        File file = new File("src/main/resources/newFile" + Calendar.getInstance().getTimeInMillis() + ".csv");

        try {
            try (OutputStream os = new FileOutputStream(file)) {
                os.write(multipartFile.getBytes());
            }
        } catch (Exception e) {
            return "Error with file";
        }
        return processTrips(file.getAbsolutePath(), true);
    }

    public String processTrips(String pathFile, boolean deleteFile) throws Exception {
        String response = "";
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(pathFile));
            String line = br.readLine();

            int indRegion = -1;
            int indOrigin = -1;
            int indDest = -1;
            int indDatetime = -1;
            int indData = -1;
            int ind = 0;
            while (null != line) {
                String[] fields = line.split(SEPARATOR);
                if (ind == 0) {
                    for (int i = 0; i < fields.length; i++) {
                        if (fields[i].trim().equalsIgnoreCase("region")) {
                            indRegion = i;
                        } else if (fields[i].trim().equalsIgnoreCase("origin_coord")) {
                            indOrigin = i;
                        } else if (fields[i].trim().equalsIgnoreCase("destination_coord")) {
                            indDest = i;
                        } else if (fields[i].trim().equalsIgnoreCase("datetime")) {
                            indDatetime = i;
                        } else if (fields[i].trim().equalsIgnoreCase("datasource")) {
                            indData = i;
                        }
                    }
                    if (indRegion == -1) {
                        response += "\nThere is no heading \"region\"";
                    }
                    if (indOrigin == -1) {
                        response += "\nThere is no heading \"origin_coord\"";
                    }
                    if (indDest == -1) {
                        response += "\nThere is no heading \"destination_coord\"";
                    }
                    if (indDatetime == -1) {
                        response += "\nThere is no heading \"datetime\"";
                    }
                    if (indData == -1) {
                        response += "\nThere is no heading \"datasource\"";
                    }
                    if (!response.equals("")) {
                        break;
                    }
                } else {
                    String regionName = fields[indRegion];
                    String originCoord = fields[indOrigin];
                    String destinationCoord = fields[indDest];
                    String datetime = fields[indDatetime];
                    String datasourceName = fields[indData];

                    originCoord = originCoord.replace("POINT (", "").replace(")", "");
                    destinationCoord = destinationCoord.replace("POINT (", "").replace(")", "");

                    String[] origins = originCoord.split(" ");
                    String[] destins = destinationCoord.split(" ");

                    Region region = regionService.addNewRegion(regionName);
                    Datasource datasource = datasourceService.addNewDatasource(datasourceName);
                    Path path = pathService.addNewPath(sf.parse(datetime), new BigDecimal(origins[0]).setScale(10, BigDecimal.ROUND_HALF_UP),
                            new BigDecimal(origins[1]).setScale(10, BigDecimal.ROUND_HALF_UP),
                            new BigDecimal(destins[0]).setScale(10, BigDecimal.ROUND_HALF_UP),
                            new BigDecimal(destins[1]).setScale(10, BigDecimal.ROUND_HALF_UP));

                    Trip trip = new Trip();
                    trip.setDatasource(new Datasource(datasource.getId()));
                    trip.setPath(new Path(path.getId()));
                    trip.setRegion(new Region(region.getId()));
                    tripRepository.save(trip);
                }
                line = br.readLine();
                ind++;
            }

        } catch (Exception e) {
            response = e.getMessage();
        } finally {
            if (null != br) {
                br.close();
            }
        }
        if (response == null || response.equals("")) {
            response = "File processed correctly";
        }
        if(deleteFile) {
            File fileDel = new File(pathFile);
            fileDel.delete();
        }
        return response;
    }

    public List<TripRegionDto> getPromTrips() {
        List<TripRegionDto> list = tripRepository.getPromTrips();
        return list;
    }

    public List<TripWeeklyDto> getWeekly(Integer year) {
        List<TripWeeklyDto> list = tripRepository.getWeekly(year);
        return list;
    }
}
