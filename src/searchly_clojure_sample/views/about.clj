(ns searchly-clojure-sample.views.about
  (:use [hiccup.core :only [html]])
  (:require [searchly-clojure-sample.views.layout :as layout]))

(defn index []
  (layout/common "Searchly Clojure Sample"
    [:div [:h1 "About"]
     ]
    [:div.row [:div.span12 [:p "Sample Clojure  application that uses " [:a {:href "http://www.searchly.io"} " Searchly "]
                            "for full text search."]
               [:p "Feel free to copy, edit and use for your projects."]
               ]
     ]
    ))

