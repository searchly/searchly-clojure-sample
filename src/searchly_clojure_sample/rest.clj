(ns searchly-clojure-sample.rest
  (:require [searchly-clojure-sample.views.home :as home-view]
            [compojure.core :refer [GET POST PUT DELETE ANY defroutes wrap-routes routes]]
            [searchly-clojure-sample.views.search :as search-view]
            [clojurewerkz.elastisch.rest :as esr]
            [clojurewerkz.elastisch.rest.response :as esrsp]
            [clojurewerkz.elastisch.rest.index :as esi]
            [clojurewerkz.elastisch.rest.document :as esd]
            [searchly-clojure-sample.views.layout :as layout]
            [searchly-clojure-sample.views.home :as home]
            [searchly-clojure-sample.views.about :as about]
            [compojure.route :as route]
            [ring.adapter.jetty :as jetty]
            [ring.middleware.defaults :refer [wrap-defaults api-defaults]]))

(defn index-data []
  (let [conn (esr/connect "http://site:4895bab994521ff49ee4cffb622f690f@localhost:9200")]
    (if-not (esi/exists? conn "tweets")
      ((esi/create conn "tweets")
        (esd/create conn "tweets" "tweet" {:username "Tweety" :text "Tweety Bird (also known as Tweety Pie or simply Tweety) is a fictional Yellow Canary in the Warner Bros."})
        (esd/create conn "tweets" "tweet" {:username "Tom" :text "Thomas Tom Cat is a fictional character and the main protagonist in Metro-Goldwyn-Mayer's series of Tom and Jerry theatrical cartoon short films."})
        )
      )
    )
  ;; go to home
  (home-view/index)
  )

(defn search [qparam]
  (let [conn (esr/connect "http://site:4895bab994521ff49ee4cffb622f690f@localhost:9200")
        res (esd/search conn "tweets" "tweet" :query {:match {:text qparam}})
        hits (esrsp/hits-from res)]
    (search-view/index hits)
    )
  )

(defroutes search-routes
           (POST "/search" {params :params} (search (get params :q))))

(defroutes index-routes
           (GET "/index" [] (index-data)))

(defroutes base-routes
           (GET "/" [] (home/index))
           (GET "/about" [] (about/index))
           (route/resources "/")
           (route/not-found (layout/four-oh-four)))

(def app
  (->
    (routes
      index-routes
      search-routes
      base-routes
      )
    (wrap-routes wrap-defaults api-defaults)))

(defn start [port]
  (jetty/run-jetty app {:port port :join? false}))

