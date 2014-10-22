/**
 * Created by QuangTV on 10/22/2014.
 */

$(document).ready(function(){
    $.ajax({
        url: '/findLimitJobs.do',
        type: 'GET',
        success: function(listJob) {
            var dataString = "";
            $.each(listJob, function(index, job) {
                dataString +=
                    "<tr>"
                        + "<td>"
                            + "<p><a href='WEB-INF/job.html'>" + job.jobName + "</a> <small class='label label-success'>" + job.jobName + "</small></p>"
                            + "<p>Google Enterprises</p>"
                        + "</td>"
                        + "<td class='job-location'>"
                            + "<p><i class='glyphicon glyphicon-calendar'></i>" +  job.jobName + "</p>"
                            + "<p><i class='glyphicon glyphicon-map-marker'></i>" +  job.jobName + "</p>"
                        + "</td>"
                    + "</tr>"
            });

            $('#jobTable').append(dataString);
        }
    });
});
