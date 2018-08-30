// Cargo los datos de Games
$.get("/api/games").done(function(data){
    app.games = data;

});

// Declaracion del Vue
var app = new Vue({
  el: '#app',
    data: {
        games: []
    }
});

