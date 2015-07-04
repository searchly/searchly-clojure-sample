(ns searchly-clojure-sample.views.home
  (:use [hiccup.core :only [html]]
        [hiccup.page :only [doctype]])
  (:require [searchly-clojure-sample.views.layout :as layout]))

(defn index []
  (layout/common "Searchly Clojure Sample"
    [:div {:class "row"}
     [:div {:class "span12"}
      [:div {:class " hero-unit"}
       [:h2 "Searchly Sample Clojure Application"]
       [:p "This example illustrates basic search features of Searchly (powered by Elasticsearch)."]
       [:p "Sample application is using"
        [:a {:href "http://http://clojureelasticsearch.info/" :target "_blank"} " Elastisch "]
        "Clojure Elasticsearch client to integrate with Searchly."
        ]
       [:p "To create initial index and sample data click"
        [:a {:href "/index"} " Create Sample Index&Data! "] "(2 sample documents will be created.) "
        ]
       [:p "Type 'tweety' or 'tom' to searchbox at top of right corner and hit enter for sample search results."]
       ]
      ]
     ]
    ))

