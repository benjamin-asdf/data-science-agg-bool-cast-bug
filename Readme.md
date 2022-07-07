For reproducing a bug with dataset https://github.com/techascent/tech.ml.dataset

1) pull repo, I just put nippy example issue data into the repo
2) load issue.clj


```text
1. Unhandled java.lang.ClassCastException
   class java.lang.Boolean cannot be cast to class
   tech.v3.datatype.Consumers$StagedConsumer (java.lang.Boolean is in
   module java.base of loader 'bootstrap';
   tech.v3.datatype.Consumers$StagedConsumer is in unnamed module of
   loader 'app')

            reductions.clj:  144  tech.v3.dataset.reductions.SetConsumer/combine
            Consumers.java:   39  tech.v3.datatype.Consumers$StagedConsumer/combineList
            reductions.clj:  151  tech.v3.dataset.reductions/distinct/reify
                  impl.clj:  235  tech.v3.dataset.reductions.impl/aggregate-reducer/reify
            reductions.clj:  550  tech.v3.dataset.reductions/aggregate
            reductions.clj:  515  tech.v3.dataset.reductions/aggregate
            reductions.clj:  556  tech.v3.dataset.reductions/aggregate
            reductions.clj:  515  tech.v3.dataset.reductions/aggregate
                      REPL:    9  issue/eval24252
                      REPL:    9  issue/eval24252
             Compiler.java: 7194  clojure.lang.Compiler/eval
             Compiler.java: 7149  clojure.lang.Compiler/eval
                  core.clj: 3215  clojure.core/eval
                  core.clj: 3211  clojure.core/eval
    interruptible_eval.clj:   87  nrepl.middleware.interruptible-eval/evaluate/fn/fn
                  AFn.java:  152  clojure.lang.AFn/applyToHelper
                  AFn.java:  144  clojure.lang.AFn/applyTo
                  core.clj:  667  clojure.core/apply
                  core.clj: 1990  clojure.core/with-bindings*
                  core.clj: 1990  clojure.core/with-bindings*
               RestFn.java:  425  clojure.lang.RestFn/invoke
    interruptible_eval.clj:   87  nrepl.middleware.interruptible-eval/evaluate/fn
                  main.clj:  437  clojure.main/repl/read-eval-print/fn
                  main.clj:  437  clojure.main/repl/read-eval-print
                  main.clj:  458  clojure.main/repl/fn
                  main.clj:  458  clojure.main/repl
                  main.clj:  368  clojure.main/repl
               RestFn.java: 1523  clojure.lang.RestFn/invoke
    interruptible_eval.clj:   84  nrepl.middleware.interruptible-eval/evaluate
    interruptible_eval.clj:   56  nrepl.middleware.interruptible-eval/evaluate
    interruptible_eval.clj:  152  nrepl.middleware.interruptible-eval/interruptible-eval/fn/fn
                  AFn.java:   22  clojure.lang.AFn/run
               session.clj:  218  nrepl.middleware.session/session-exec/main-loop/fn
               session.clj:  217  nrepl.middleware.session/session-exec/main-loop
                  AFn.java:   22  clojure.lang.AFn/run
               Thread.java:  833  java.lang.Thread/run

   ```

if you take 10 it does not happen

```
(ds-reduce/aggregate
   {:n-elems (ds-reduce/row-count)
    :genre (ds-reduce/count-distinct :genre)}
   [(ds/head (ds/->dataset "example-genres.nippy") 10)])```

``` (ds-reduce/aggregate
   {:n-elems (ds-reduce/row-count)}
   [(ds/->dataset "example-genres.nippy")])
```

if you remove the count distinct it also does not happen
