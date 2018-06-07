$(document).ready(function() {
    $('#selectCity').change(function () {
        ajaxPostDegree($("#selectCity").val());
    });

    function ajaxPostDegree(city) {
        $.ajax({
            type: "POST",
            contentType: "application/json",
            url: "/api/property/streets",
            data: JSON.stringify(city),
            dataType: 'json',
            success: function (result) {
                console.log(result);
                var option = "";
                result.forEach(function (i, course) {
                    option += "<option value=" + result[course] + ">" + result[course] + "</option>";
                })
                $("#street-list").html(option);
            },
            error: function (e) {
                alert("Error!")
                console.log("ERROR: ", e);
            }
        });
    }
});