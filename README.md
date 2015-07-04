## Searchly Sample Clojure Application.

This example illustrates basic search features of Searchly.

Sample application is using [Elastisch](http://clojureelasticsearch.info/) Clojure Elasticsearch client to integrate with Searchly.

To create initial index and sample data click Create Sample Index&Data! (2 sample documents will be created.)

Type 'tweety' or 'tom' to searchbox at top of right corner and hit enter for sample search results.


## Local Setup

To run example in your local environment with a local Elasticsearch instance, change connection string with local url string inside
rest.clj  to

```
    (esr/connect "http://localhost:9200")
```

## Heroku Deployment

This sample can be deployed to Heroku with no change.

* Install SearchBox Elasticsearch Addon

Deploy sample application.
