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
    // data = JSON.stringify(params, undefined, 4)

    console.log('items_in_fridge:\n', items);
    console.log('recipes:\n', recipe_obj);
    console.log('params:\n', params);

    $.ajax({
      url: 'http://localhost:8080/recipe-finder/query',
      type: 'POST',
      headers: {
        'Content-Type': 'application/json',
        'charset': 'utf-8'
      },
      data: JSON.stringify(params)
    }).success(function (response) {
      console.log(response);
      var result = response.data;
      $('#result').html(result);
    }).fail(function (response) {
      var result = 'Server Error!';
      $('#result').html(result);
      alert(result);
    })
  });
});
