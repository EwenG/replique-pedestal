# Replique-pedestal

This an example project for using [replique](https://github.com/EwenG/replique.el) with [pedestal](https://github.com/pedestal/pedestal).

- Clone the project
- Start a REPL (`M-x replique/repl` ) in the directory where the project was cloned
- Load the `replique-pedestal.core` namespace. From the `replique-pedestal.core` namespace, start the server `(http/start server)`. The server is started on port `8080`.
- Turn the REPL into a cljs REPL: `M-x replique/cljs-repl`
- Open a browser tab at `localhost:8080`
- Notice that the HTML markup references a `main.js` file. The `main.js` file already exists in the directory `resources/public/`. `resources/public/` is the assets folder of the web server started by pedestal.
- At this point, the cljs REPL should be fully functional. The browser has successfully connected to it.
- Open the browser web console. You should see that the browser is complaining that it cannot load the `replique-pedestal.front` namespace. The reason is that `main.js` tries to load the `replique-pedestal.front` namespace, but this namespace has not yet been compiled. Let's fix it.
- Open the `front.cljs` file and load it: `M-x replique/load-file`. The `replique-pedestal.front` has been loaded in the browser and compiled to disk.
- Reload the browser page, notice how the `replique-pedestal.front` namespace is executed again.


The `main.js` file was already there when you cloned the repository. Let's see how this file was generated.

- Quit the cljs REPL: `:cljs/quit`
- From the `replique-pedestal.core` namespace, change the script included in the index page to be: `<script src=\"/main2.js\"></script>`. Reload the namespace: `M-x replique/load-file`
- Turn the REPL into a cljs REPL: `M-x replique/cljs-repl`
- Reload the browser page. Notice that the browser complains that the `main2.js` cannot be found
- Try to type something in the cljs REPL. Nothing happens because the REPL is waiting for a browser to connect. Let's fix it.
- Execute the following command: `M-x replique/output-main-js-file`. Enter the following path on the first prompt: `resources/public/main2.js`. Enter the following namespace on the second prompt: `replique-pedestal.front`.
- Reload the browser page ... it works !
