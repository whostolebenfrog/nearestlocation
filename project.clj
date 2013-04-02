(defproject nearestlocation "0.1.0"
  :description "A wrapper for clj-kdtree to provide easy use in Java to find nearest locations to a given point"
  :url "https://github.com/dmcgillen/nearestlocation"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}

  :aot [com.github.nearestlocation.types com.github.nearestlocation.core]

  :dependencies [[org.clojure/clojure "1.5.1"]
                 [clj-kdtree "1.1.0"]]

  :profiles {:dev {:dependencies [[midje "1.5.1"]]
                   :plugins [[lein-midje "3.0.0"]]}})
