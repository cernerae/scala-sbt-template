# scala-sbt-template

<span><img src="https://www.docker.com/sites/default/files/d8/2019-07/horizontal-logo-monochromatic-white.png" width="300" /></span>
<span><img src="https://egkatzioura.files.wordpress.com/2017/05/typesafe_sbt_svg.png" width="300" /></span>

## Overview

Use this repository as a template to create new Scala SBT projects with Docker Plugin functionality. For use with Jenkins or any other tool.

## Getting Started

1. Clone this repository
2. Change <i>/build.properties</i> file:
    - `project.organization` = Project Organization
    - `project.name` = Project Name
    - `project.version` = Project Version
    - `project.scala-version` = 2.13.5
    - `docker.organization` = Docker Organization to publish image to
    - `docker.main-class` = Main Scala class for Docker Plugin to build
    - `docker.base-image` = Base Docker image to build from
3. Set up for CI/CD environment
