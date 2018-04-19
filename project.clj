(defproject geojson-rgf93-wgs84 "0.1.0-SNAPSHOT"
  :description "Convert coordinates of a geojson file from rfg93 to wgs84"
  :url "https://github.com/bzg/geojson-rgf93-wgs84"
  :license {:name "Eclipse Public License"
            :url  "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.9.0"]
                 [com.rpl/specter "1.1.0"]
                 [clj-rgf93-wgs84 "0.1.0"]
                 [cheshire "5.8.0"]]
  :main geojson-rgf93-wgs84.core)
