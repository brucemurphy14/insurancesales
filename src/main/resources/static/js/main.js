$(document).ready(function () {

    $("#search-form").submit(function (event) {

        //stop submit the form, we will get it manually.
        event.preventDefault();

        fire_ajax_submit();

    });

});

function fire_ajax_submit() {

    //var search = {}
    //search["username"] = $("#username").val();

    var searchText = $("#username").val();

    $("#btn-search").prop("disabled", true);

    $.ajax({
        type: "GET",
        contentType: "application/json",
        url: "/api/client" + "/" + searchText,
        //data: JSON.stringify(7),
        dataType: 'json',
        cache: false,
        timeout: 600000,
        success: function (data) {

            var json = "<h4>Ajax Response</h4>&lt;pre&gt;"
                + JSON.stringify(data, null, 4) + "&lt;/pre&gt;";
            $('#feedback').html(json);

            console.log("SUCCESS : ", data);
            $("#btn-search").prop("disabled", false);

        },
        error: function (e) {

            var json = "<h4>Ajax Response</h4>&lt;pre&gt;"
                + e.responseText + "&lt;/pre&gt;";
            $('#feedback').html(json);

            console.log("ERROR : ", e);
            $("#btn-search").prop("disabled", false);

        }
    });

}