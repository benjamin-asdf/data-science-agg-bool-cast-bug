(ns
    issue
    (:require
     #_[tech.v3.dataset.io.csv]
     [tech.v3.dataset :as ds]
     [tech.v3.dataset.reductions :as ds-reduce]))


(ds-reduce/aggregate
   {:n-elems (ds-reduce/row-count)}
   [(ds/->dataset "example-genres.nippy")])
