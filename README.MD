# Recipe Finder
[![Build Status](https://travis-ci.com/ZintrulCre/Recipe-Finder.svg?branch=master)](https://travis-ci.com/ZintrulCre/Recipe-Finder)

- http://35.197.185.63/

## Introduction

- Input

    - items in fridge
    - format: item, amount, unit, use-by, e.g.

```
bread,10,slices,25/12/2019
cheese,10,slices,25/12/2019
butter,250,grams,25/12/2018
peanut butter,250,grams,8/2/2019
mixed salad,150,grams,26/12/2016
```

    - recipes in json format, e.g.

```
[
    {
        "name": "grilled cheese on toast",
        "ingredients": [
            {
                "item": "bread",
                "amount": "2",
                "unit": "slices"
            },
            {
                "item": "cheese",
                "amount": "2",
                "unit": "slices"
            }
        ]
    },
    {
        "name": "salad sandwich",
        "ingredients": [
            {
                "item": "bread",
                "amount": "2",
                "unit": "slices"
            },
            {
                "item": "mixed salad",
                "amount": "100",
                "unit": "grams"
            }
        ]
    }
]
```

## Implementation

- Backend
    - Java 8
        - simplejson
    - Spring Boot
    - Maven

- Frontend
    - JavaScript
    - BootStrap 4
    - JQuery

- Deployment
    - Google Cloud Platform
        - Nginx
    - Travis CI
    - Jenkins