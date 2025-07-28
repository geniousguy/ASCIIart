# ASCII Art

[![pipeline status](https://gitlab.fit.cvut.cz/BI-OOP/B241/asciiart/badges/master/pipeline.svg)](https://gitlab.fit.cvut.cz/BI-OOP/B241/asciiart)

The idea of this project is to load images, translate them into ASCII ART images, optionally apply filters, and save them. (https://courses.fit.cvut.cz/BI-OOP/projects/ASCII-art.html)

## How to do it

1. **Make your repository private**
2. **Read [the instructions](https://courses.fit.cvut.cz/BI-OOP/projects/ASCII-art.html)**
3. Play [lofi hip hop radio](https://www.youtube.com/watch?v=jfKfPfyJRdk)
4. [???](https://www.youtube.com/watch?v=ZXsQAXx_ao0)
5. Profit

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

