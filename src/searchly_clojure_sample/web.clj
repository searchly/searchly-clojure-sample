(ns searchly-clojure-sample.web
  (:require [searchly-clojure-sample.rest :as rest])
  )

(defn -main [& args]
  (let [port (Integer. (or (System/getenv "PORT") 8080))]
    (rest/start port)))