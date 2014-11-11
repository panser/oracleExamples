/**
 * Created by Panov Sergey on 11/5/2014.
 */
function parseJsonError(data) {
    for (var i=0; i<data.length; i++) {
        var dangerBlock = $("#localAlertDangerBlock").clone().attr('id', '');
        dangerBlock.find('.localMessageDanger').text(data[i].message);
        dangerBlock.appendTo("#allertMessages");
        dangerBlock.show();
    }
}