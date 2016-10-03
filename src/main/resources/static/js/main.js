$(document).ready(function () {
    refreshChecksSchedule();
});

function refreshChecksSchedule() {
    setInterval(function () {
        getChecks();
    }, 60000);
}

function getChecks() {
    $.get("/check", function (checks) {
        checks.forEach(function(check) {
            console.log(check.name);
        });
    });
}