
# react-native-date-picker-component-android

## The Missing native date picker component for android, especially when you want to show a spinner picker in android 7.0

### Screenshots

![](https://github.com/Noitidart/react-native-datepicker-component-android/blob/master/screenshot-picker.png?raw=true)

![](https://github.com/Noitidart/react-native-datepicker-component-android/blob/master/screenshot-cal.png?raw=true)

## Forked from vincentsong/react-native-datepicker-component-android

 - Fixed React, ReactNative depreciated issues

## Dependencies
` "react": ">=16.0.0"`

`"react-native": ">=0.47.0"`

## Getting started

`$ npm install react-native-date-picker-component-android --save`

### Automatic installation

`$ react-native link react-native-date-picker-component-android`

### Manual installation

#### Android

1. Open up `android/app/src/main/java/[...]/MainApplication.java`
  - Add `import com.bitup.datepickercomponent.RNDatePickerComponentPackage;` to the imports at the top of the file
  - Add `new RNDatePickerComponentPackage()` to the list returned by the `getPackages()` method
2. Append the following lines to `android/settings.gradle`:
  	```
  	include ':react-native-date-picker-component-android'
  	project(':react-native-date-picker-component-android').projectDir = new File(rootProject.projectDir, 	'../node_modules/react-native-date-picker-component-android/android')
  	```
3. Insert the following lines inside the dependencies block in `android/app/build.gradle`:
  	```
      compile project(':react-native-date-picker-component-android')
  	```


## Usage
```javascript
import DatePicker from 'react-native-date-picker-component-android';

class YourComponentClass extends Component {

  constructor(props) {
    super(props)
    this.state = { date: '1980-01-01' };
  }

  render() {
    return (
      ... //other components
      <DatePicker
        style={{ width: 320, height: 300 }}
        date={this.state.date}
        showCalendar = {true} // if you need to use calendar view, default is false
        onChange={(date) => this.setState({ date })} />
      ...//other components
    )
  }
}
```
## Known issue
The calendar mode is not working as expected, the clendar view will disappear when user changed the month twice. So only spinner mode is working now.  
