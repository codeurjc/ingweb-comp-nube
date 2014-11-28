$(function() {
    $.ajax({
        url: "http://localhost:8080/team/Marx%20Brothers"
    }).then(function(data) {
       $('.team-name').append(data.name);
       $('.team-players').append(JSON.stringify(data.players));
    });
});