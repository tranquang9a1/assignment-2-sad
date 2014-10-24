/**
 * Created by QuangTV on 10/22/2014.
 */

$(document).ready(function(){
    $.ajax({
        url: '/findLimitJobs.do',
        type: 'GET',
        dataType:'JSON',
        success: function(listJob) {
            var dataString = "";
            $.each(listJob, function(index, job) {
                var a = new Date(job.create_date)
                dataString +=
                    "<tr>"
                        + "<td>"
                            + "<p><a href='job.do?id='+job.jobID+'>" + job.jobName + "</a> <small class='label label-success'>" + job.jobName + "</small></p>"
                            + "<p>"+job.username +"</p>"
                        + "</td>"
                        + "<td class='job-location'>"
                            + "<p><i class='glyphicon glyphicon-calendar'></i>" + a.toISOString().substr(0,10) + "</p>"
                            + "<p><i class='glyphicon glyphicon-map-marker'></i>" +  job.address + "</p>"
                        + "</td>"
                    + "</tr>"
            });

            $('#tblData').append(dataString);
        }
    });
});
