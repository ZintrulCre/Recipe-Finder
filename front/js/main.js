$(document).ready(function () {
  // on submit button click
  $('#submitBtn').on('click', function () {
    // get csv & json value
    var items = $('#content-items').val();
    var recipes = $('#content-recipes').val();

    console.log('items_in_fridge:\n', items);
    console.log('recipes:\n', recipes);

    // post method
    var params = {
      items_in_fridge: items,
      recipes: recipes
    }
    $.ajax({
      url: 'http://localhost:8080/recipe-finder/query',
      type: 'POST',
      headers: {
        'Content-Type': 'application/json'
      },
      data: params
    }).done(function (response) {
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
