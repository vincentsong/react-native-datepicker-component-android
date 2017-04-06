using ReactNative.Bridge;
using System;
using System.Collections.Generic;
using Windows.ApplicationModel.Core;
using Windows.UI.Core;

namespace Com.Reactlibrary.RNDatePickerComponentAndroid
{
    /// <summary>
    /// A module that allows JS to share data.
    /// </summary>
    class RNDatePickerComponentAndroidModule : NativeModuleBase
    {
        /// <summary>
        /// Instantiates the <see cref="RNDatePickerComponentAndroidModule"/>.
        /// </summary>
        internal RNDatePickerComponentAndroidModule()
        {

        }

        /// <summary>
        /// The name of the native module.
        /// </summary>
        public override string Name
        {
            get
            {
                return "RNDatePickerComponentAndroid";
            }
        }
    }
}
