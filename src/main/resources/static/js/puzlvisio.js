$(document).ready(function() {
    var gallerylist = $('#gallerylist');

    $.ajax({
        type: "GET",
        dataType: "json",
        url: "/galleries",
        success: function(data){
            console.log(gallerylist);
            $.each(data._embedded.galleries, function(index,item) {
                gallerylist.append('<li>' + item.name + ' </li>');
            });
        }
    });
});

