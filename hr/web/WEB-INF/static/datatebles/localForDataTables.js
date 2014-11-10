$.extend( $.fn.dataTable.defaults, {
    "sPaginationType": "full_numbers"
    , "jQueryUI": true
    , stateSave: true
    , "lengthMenu": [ [10, 25, 50], [10, 25, 50] ]
//    , "lengthMenu": [ [10, 25, 50, -1 ], [10, 25, 50, "All"] ]
} );

/*
//not work ???
$(document).on('xhr.dt', function ( e, settings, json ) {
    $('#status').html( json.status );
} );
*/

function myRequest(sSource, aoData, fnCallback, oSettings) {
    oSettings.jqXHR = $.ajax({
        "dataType" : 'json',
        "cache" : 'false',
        "type" : "GET",
        "url" : sSource,
        "data" : aoData,
        "success" : function(json){
            fnCallback(json);
//            $('<div id="msg" style="display:none;"><p>This message has been added in the success callback.<br />' + json.aaData.length + ' entries have been loaded.</p></div>').insertBefore($('#departments'));
//            $('#msg').slideDown(2000);
        }
    });
}

function makeActions(data, type, full) {
//    <a onclick="alert('Department ' + ${department.id} + ' deleted !');" class="btn btn-mini" title="Remove"><span class="glyphicon glyphicon-trash"></span></a>
//    <a onclick="alert('Department ' + ${department.id} + ' edited !');" class="btn btn-mini" title="Edit"><span class="glyphicon glyphicon-edit"></span></a>
    return '<a href="mailto:' + data + '">' + data + '</a>';
}

function makeInput(data, type, full) {
    return '<a href="mailto:' + data + '">' + data + '</a>';
}