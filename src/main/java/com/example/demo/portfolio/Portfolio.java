package com.example.demo.portfolio;

import javax.persistence.*;

@Entity
@Table
public class Portfolio {
        @Id
        @SequenceGenerator(
                name = "portfolio_sequence",
                sequenceName = "portfolio_sequence",
                allocationSize = 1
        )
        @GeneratedValue(
                strategy = GenerationType.AUTO,
                generator = "portfolio_sequence"
        )
        private Integer idportfolio;
        private String description;
        private String image_url;
        private String twitter_user_name;
        private String tittle;
        private String user_id;
        private String experience_summary;
        private String last_names;
        private String names;
        private String twitter_user_id;
        private Integer id;

        public Portfolio() {
        }

        public Portfolio(Integer idportfolio,
                         String description,
                         String image_url,
                         String twitter_user_name,
                         String tittle,
                         String user_id,
                         String experience_summary,
                         String last_names,
                         String names,
                         String twitter_user_id,
                         Integer id) {
                this.idportfolio = idportfolio;
                this.description = description;
                this.image_url = image_url;
                this.twitter_user_name = twitter_user_name;
                this.tittle = tittle;
                this.user_id = user_id;
                this.experience_summary = experience_summary;
                this.last_names = last_names;
                this.names = names;
                this.twitter_user_id = twitter_user_id;
                this.id = id;
        }

        public Portfolio(String description,
                         String image_url,
                         String twitter_user_name,
                         String tittle,
                         String user_id,
                         String experience_summary,
                         String last_names,
                         String names,
                         String twitter_user_id,
                         Integer id) {
                this.description = description;
                this.image_url = image_url;
                this.twitter_user_name = twitter_user_name;
                this.tittle = tittle;
                this.user_id = user_id;
                this.experience_summary = experience_summary;
                this.last_names = last_names;
                this.names = names;
                this.twitter_user_id = twitter_user_id;
                this.id = id;
        }

        public Integer getIdportfolio() {
                return idportfolio;
        }

        public void setIdportfolio(Integer idportfolio) {
                this.idportfolio = idportfolio;
        }

        public String getDescription() {
                return description;
        }

        public void setDescription(String description) {
                this.description = description;
        }

        public String getImage_url() {
                return image_url;
        }

        public void setImage_url(String image_url) {
                this.image_url = image_url;
        }

        public String getTwitter_user_name() {
                return twitter_user_name;
        }

        public void setTwitter_user_name(String twitter_user_name) {
                this.twitter_user_name = twitter_user_name;
        }

        public String getTittle() {
                return tittle;
        }

        public void setTittle(String tittle) {
                this.tittle = tittle;
        }

        public String getUser_id() {
                return user_id;
        }

        public void setUser_id(String user_id) {
                this.user_id = user_id;
        }

        public String getExperience_summary() {
                return experience_summary;
        }

        public void setExperience_summary(String experience_summary) {
                this.experience_summary = experience_summary;
        }

        public String getLast_names() {
                return last_names;
        }

        public void setLast_names(String last_names) {
                this.last_names = last_names;
        }

        public String getNames() {
                return names;
        }

        public void setNames(String names) {
                this.names = names;
        }

        public String getTwitter_user_id() {
                return twitter_user_id;
        }

        public void setTwitter_user_id(String twitter_user_id) {
                this.twitter_user_id = twitter_user_id;
        }

        public Integer getId() {
                return id;
        }

        public void setId(Integer id) {
                this.id = id;
        }

        @Override
        public String toString() {
                return "portfolio{" +
                        "idportfolio=" + idportfolio +
                        ", description='" + description + '\'' +
                        ", image_url='" + image_url + '\'' +
                        ", twitter_user_name='" + twitter_user_name + '\'' +
                        ", tittle='" + tittle + '\'' +
                        ", user_id='" + user_id + '\'' +
                        ", experience_summary='" + experience_summary + '\'' +
                        ", last_names='" + last_names + '\'' +
                        ", names='" + names + '\'' +
                        ", twitter_user_id='" + twitter_user_id + '\'' +
                        ", id=" + id +
                        '}';
        }
}
