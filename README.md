# ASCII Art

Scala application for converting images to ASCII art and applying filters on them.
The project is made for practice of OOP principles and design patterns including high cohesion and low coupling.

## About the project
- the project aligns with high cohesion and low coupling principles
- makes use of polymorphism
- is separated into models, modules, process and ui
- is tested

## Command line arguments
- recommended command for testing:
  - run --image "src/images/letter.png" --flip y --brightness -20 --invert --output-file "src/images/converted.txt" --output-console
  - or use jpg_fire.jpg for a smaller image

## How to run
- open in intellij with installed scala plugin
- sbt run
- sbt test for tests

