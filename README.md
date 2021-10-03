# Object Detector App using MLKit image classification

## Overview

This is an application created by me for the bachelor's thesis at the Faculty of Computer Science.
It is created with [Google ML Kit APIs](https://developers.google.com/ml-kit/guides) and following the
[new Material for ML design guidelines](https://material.io/design/machine-learning/).
The application itself aims to detect and track the object behind the camera (Object Decetion & Tracking API) - an workflow for object decetion and search
using a custom TensorFlow Lite model.


## Trained model

This TensorFlow model was downloaded from [tfhub](https://tfhub.dev/) for higher accessibility.
Also, a means of data training is represented by specialized online platforms, such as [teachablemachine](https://teachablemachine.withgoogle.com/)
the platform I used.

## Data management system

In this application we used the Firebase database, which is specialized in projects responsible for detecting and tracking objects.
Android Studio is also in close connection with the Firebase database system,
that's why adding the Firebase system to a project for the Android operating system doesn't take much time and effort

## Live scenario

It uses the camera to obtain input data, thus processing the detected objects.
With the help of the Settings you can configure certain operating options of the camera.
