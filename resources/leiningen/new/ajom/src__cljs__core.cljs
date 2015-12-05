(ns {{raw-name}}.core
  (:require [cljs.nodejs :as node]))

;; reference to atom shell API
(def ashell (node/require "atom"))

;; js/atom is not the same as require 'atom'.
(def commands (.-commands js/atom))

;; get atom.CompositeDisposable so we can work with it
(def composite-disposable (.-CompositeDisposable ashell))

;; Initialise new composite-disposable so we can add stuff to it later
(def subscriptions
    (new composite-disposable))

(defn toggle []
    (.log js/console "{{raw-name}} got toggled!"))

(defn deactivate []
    (.log js/console "Deactivating {{raw-name}}..."))

(defn serialize []
  nil)

(defn activate [state]
  (.log js/console "Hello World from {{raw-name}}")
  (.add subscriptions
        (.add commands "atom-workspace" "{{raw-name}}:toggle" toggle)))
