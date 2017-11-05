import React, {Component} from 'react';
import PropTypes from 'prop-types';
import { requireNativeComponent, View } from 'react-native';

/**
 * React native JS component
 */
class DatePickerComponent extends Component {

  constructor(props) {
    super(props);
  }

  /**
   * Translate native event to react native event
   */
  onChange = (event) => {
    if (!this.props.onChange) {
      return;
    }
    this.props.onChange(event.nativeEvent.value);
  }

  render() {
    var props = { ...this.props };
    props.onStartShouldSetResponder = () => true;
    props.onResponderTerminationRequest = () => false;
    return (
      <RCTDatePickerComponent {...props}
        onChange={this.onChange} />
    )
  }
}

/**
 * PropTypes
 */
DatePickerComponent.propTypes = {
  ...View.propTypes,
  onChange: PropTypes.func,
  showCalendar: PropTypes.bool,
  date: PropTypes.string
}

/**
 * native component from Android
 */
var RCTDatePickerComponent = requireNativeComponent(
  'RCTDatePickerComponent',
  DatePickerComponent, {
    nativeOnly: {
      onChange: true
    }
  });

module.exports = DatePickerComponent;
