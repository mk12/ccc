(defproject mk12/ccc "0.1"
  :description "Solutions to CCC problems"
  :url "http://github.com/mk12/ccc"
  :license {:name "MIT License"
            :url "http://opensource.org/licenses/MIT"}
  :dependencies [[org.clojure/clojure "1.5.1"]]
  :main ^:skip-aot ccc.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
