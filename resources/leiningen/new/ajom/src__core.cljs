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

(node/enable-util-print!)

(defn ^:export deactivate []
    (.log js/console "deactivating..."))

(defn ^:export toggle []
    (.log js/console "I got toggled!"))

(defn ^:export activate [state]
  (.log js/console "Hello World")
  (.add subscriptions
        (.add commands "atom-workspace" "{{raw-name}}:toggle" toggle)) )

(defn noop [] nil)
(set! *main-cli-fn* noop)

;; We need to set module.exports to our core class.
;; Atom is using {{raw-name}}.activate on this
(aset js/module "exports" proton.core)
