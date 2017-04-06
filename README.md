
# react-native-date-picker-component-android

## Missing native date picker component for android

## Getting started

`$ npm install react-native-date-picker-component-android --save`

### Mostly automatic installation

`$ react-native link react-native-date-picker-component-android`

### Manual installation


#### iOS

1. In XCode, in the project navigator, right click `Libraries` ➜ `Add Files to [your project's name]`
2. Go to `node_modules` ➜ `react-native-date-picker-component-android` and add `RNDatePickerComponentAndroid.xcodeproj`
3. In XCode, in the project navigator, select your project. Add `libRNDatePickerComponentAndroid.a` to your project's `Build Phases` ➜ `Link Binary With Libraries`
4. Run your project (`Cmd+R`)<

#### Android

1. Open up `android/app/src/main/java/[...]/MainActivity.java`
  - Add `import com.bitup.datepickercomponent.RNDatePickerComponentAndroidPackage;` to the imports at the top of the file
  - Add `new RNDatePickerComponentAndroidPackage()` to the list returned by the `getPackages()` method
2. Append the following lines to `android/settings.gradle`:
  	```
  	include ':react-native-date-picker-component-android'
  	project(':react-native-date-picker-component-android').projectDir = new File(rootProject.projectDir, 	'../node_modules/react-native-date-picker-component-android/android')
  	```
3. Insert the following lines inside the dependencies block in `android/app/build.gradle`:
  	```
      compile project(':react-native-date-picker-component-android')
  	```

#### Windows
[Read it! :D](https://github.com/ReactWindows/react-native)

1. In Visual Studio add the `RNDatePickerComponentAndroid.sln` in `node_modules/react-native-date-picker-component-android/windows/RNDatePickerComponentAndroid.sln` folder to their solution, reference from their app.
2. Open up your `MainPage.cs` app
  - Add `using Com.Reactlibrary.RNDatePickerComponentAndroid;` to the usings at the top of the file
  - Add `new RNDatePickerComponentAndroidPackage()` to the `List<IReactPackage>` returned by the `Packages` method


## Usage
```javascript
import RNDatePickerComponentAndroid from 'react-native-date-picker-component-android';

// TODO: What to do with the module?
RNDatePickerComponentAndroid;
```
  