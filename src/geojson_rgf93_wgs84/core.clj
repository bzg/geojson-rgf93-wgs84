(ns geojson-rgf93-wgs84.core
  (:require [clojure.java.io :as io]
            [cheshire.core :as json]
            [clojure.spec.alpha :as s]
            [com.rpl.specter :refer :all]
            [clj-rgf93-wgs84.core :refer :all]))

(defn -main
  "Convert geojson coordinates from RGF93 to WGS84.
  
  The first argument is a geojson file with RGF93 coordinates and the
  optional second argument is the output file."
  [& args]
  (let [output-file (second args)
        parsed-file (json/parse-string (slurp (first args)) true)
        output-string
        (json/generate-string
         (transform
          ;; Goes into data structure...
          [:features ALL :geometry :coordinates ALL ALL ALL
           ;; ... until it reaches coordinates
           #(s/valid? (s/coll-of float? :kind vector? :count 2) %)]
          (fn [[lat lng]] (rgf93-to-wgs84 lat lng))
          (json/parse-string (slurp (first args)) true))
         {:pretty (empty? output-file)})]
    (if output-file (spit output-file output-string)
        (println output-string))))
