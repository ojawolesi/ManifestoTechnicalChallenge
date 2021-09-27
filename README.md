# Manifesto Technical Challenge

# Task 1
HTML and CSS

## About this task
In this task, there was the option to choose one of fifteen [Josef Müller-Brockmann](https://en.wikipedia.org/wiki/Josef_M%C3%BCller-Brockmann) designs using HTML and CSS. I chose his design poster For The Zurich Tonhalle 1951. Müller-Brockmann was a Swiss graphic designer who pioneered the International Typographic Style.

[Zurich Tonhalle (1951)]() |  [Musica Viva (1959)]()
:-------------------------:|:-------------------------:
!["Musica Viva" poster from 1959 in its web version](screenshots/musica-viva-1959.png)  |  !["Musica Viva" poster from 1961 in its web version](screenshots/musica-viva-1961.png)

# Task 2
An Automated Teller Machine (ATM) Command Line Interface (CLI) application developed in Java. 
## Installation
``` bash
# clone the repository
$ cd <directory>
$ git clone https://https://github.com/ojawolesi/ManifestoTechnicalChallenge.git
# run
$ java -jar ManifestoTechnicalChallenge/task2/target/ManifestoTechnicalChallenge-1.0-SNAPSHOT.jar <filepath>
```

## How It Works

The program is a command line application. In order to input entries  for the ATM, you will need to enter them in a .txt file in the format mentioned in the [Technical Challenge brief](https://github.com/ojawolesi/ManifestoTechnicalChallenge/blob/master/Technical%20test%20-%20full%20stack.docx%20(9)%20(2).pdf).

The main function loops through the files line-by-line to validate customer account details and perform basic
operations including balance inquiries and cash withdrawals.