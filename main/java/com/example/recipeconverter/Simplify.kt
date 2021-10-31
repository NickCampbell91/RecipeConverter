package com.example.recipeconverter

class Simplify() {
    var a = 0F
    var cups = 0
    var halfCups = 0
    var thirdCups = 0
    var quarterCups = 0
    var tablespoons = 0
    var teaspoons = 0

    fun simplifyMeasurement(measurement: Float) {
        a = measurement

        // Store number of whole cups in var
        while (a >= 1) {
            a--
            cups++
        }

        // If at or above 3/4 cups, remaining amount will be divided between
        // three quarter cups and whatever tablespoons and teaspoons remain.
        if (a >= .75) {
            a -= .75F
            quarterCups += 3

            if (a >= 0.0625f && a % 0.0625f < 0.020833f) {
                while (a > 0) {
                    a -= 0.0625f
                    tablespoons++
                }
            }
            if (a % 0.020833f < 0.020833f) {
                while (a > 0) {
                    a -= 0.020833f
                    teaspoons++
                }
            }
        }

        // If at or above 2/3 cups, remaining amount will be divided between
        // two third cups and whatever tablespoons and teaspoons remain.
        else if (a >= (2/3)) {
            a -= (2/3)
            thirdCups += 2

            if (a >= 0.0625f && a % 0.0625f < 0.020833f) {
                while (a > 0) {
                    a -= 0.0625f
                    tablespoons++
                }
            }
            if (a % 0.020833f < 0.020833f) {
                while (a > 0) {
                    a -= 0.020833f
                    teaspoons++
                }
            }
        }

        // If at or above 1/2 cup, remaining amount will be divided between
        // one half cup and whatever tablespoons and teaspoons remain.
        else if (a >= .5) {
            a -= .5F
            halfCups += 1

            if (a >= 0.0625f && a % 0.0625f < 0.020833f) {
                while (a > 0) {
                    a -= 0.0625f
                    tablespoons++
                }
            }
            if (a % 0.020833f < 0.020833f) {
                while (a > 0) {
                    a -= 0.020833f
                    teaspoons++
                }
            }
        }

        // If at or above 1/3 cup, remaining amount will be divided between
        // one third cup and whatever tablespoons and teaspoons remain.
        else if (a >= .33f) {
            a -= .33f
            thirdCups += 1

            if (a >= 0.0625f && a % 0.0625f < 0.020833f) {
                while (a > 0) {
                    a -= 0.0625f
                    tablespoons++
                }
            }
            if (a % 0.020833f < 0.020833f) {
                while (a > 0) {
                    a -= 0.020833f
                    teaspoons++
                }
            }
        }

        // If at or above 1/4 cup, remaining amount will be divided between
        // one half cup and whatever tablespoons and teaspoons remain.
        else if (a >= .25) {
            a -= .25F
            quarterCups += 1

            if (a >= 0.0625f && a % 0.0625f < 0.020833f) {
                while (a > 0) {
                    a -= 0.0625f
                    tablespoons++
                }
            }
            if (a % 0.020833f < 0.020833f) {
                while (a > 0) {
                    a -= 0.020833f
                    teaspoons++
                }
            }
        }

        // If below 1/4 cup, remaining amount will be divided between
        // whatever tablespoons and teaspoons remain.
        else if (a < .25) {
            if (a >= 0.0625f && a % 0.0625f < 0.020833f) {
                while (a > 0) {
                    a -= 0.0625f
                    tablespoons++
                }
            }
            if (a % 0.020833f < 0.020833f) {
                while (a > 0) {
                    a -= 0.020833f
                    teaspoons++
                }
            }
        }
    }
}