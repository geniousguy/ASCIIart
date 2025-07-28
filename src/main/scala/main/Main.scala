package main
import ui.UserInterface

// --image "src/images/jpg_fire_small.jpg" --table linear --invert --flip x --brightness 10 --output-console
@main def main(arguments: String*): Unit = {
  UserInterface().run(arguments.toList)
}

