$(document).ready(function () {
  // on submit button click
  $('#submitBtn').on('click', function () {
    // get csv & json value
    var items = $('#content-items').val();
    var recipe_obj = JSON.parse($('#content-recipes').val())
    document.getElementById('content-recipes').value = JSON.stringify(recipe_obj, undefined, 4);

    // post method
    var params = {
      'items_in_fridge': items,
      'recipes': recipe_obj
    }

    // console.log('items_in_fridge:\n', items);
    // console.log('recipes:\n', recipe_obj);

    $.ajax({
      url: 'http://35.197.185.63/:8080/recipe-finder/query',
      type: 'POST',
      headers: {
        'Content-Type': 'application/json',
        'charset': 'utf-8'
      },
      data: JSON.stringify(params)
    }).done(function (response) {
      console.log(response);
      var result = response.data;
      $('#result').html(result);
    }).fail(function (response) {
      console.log(response.responseText);
      var result = 'Server Error!';
      $('#result').html(result);
      alert(result);
    })
  });
});
