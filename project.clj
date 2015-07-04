(defproject searchly-clojure-sample "0.0.1-SNAPSHOT"
            :description "Searchly clojure sample application"
            :dependencies [[org.clojure/clojure "1.6.0"]
                           [ring/ring-jetty-adapter "1.4.0-RC2"]
                           [compojure "1.3.4"]
                           [hiccup "1.0.5"]
                           [clojurewerkz/elastisch "2.1.0"]
                           [ring/ring-defaults "0.1.5"]]
            :min-lein-version "2.0.0"
            :main searchly-clojure-sample.web
            :plugins [[lein-ring "0.9.6"]]
            :ring {:handler searchly-clojure-sample.rest/app})