import React, {useState} from 'react';
import {
  Text,
  View,
  StyleSheet,
  Button,
  ViewStyle,
  TextInput as TextInputRN,
  Platform,
  Pressable,
  ScrollView,
} from 'react-native';
import {
  TextInput,
  DropdownMenu,
  TriStateCheckbox,
  BottomSheet,
  Container,
} from '@shovel-kun/native-ui';

function App(): React.JSX.Element {
  const [formData, setFormData] = useState({
    name: '',
    email: '',
    country: '',
    password: '',
  });

  const [checkboxStates, setCheckboxStates] = useState({
    checkbox1: 'on',
    checkbox2: 'off',
    checkbox3: 'indeterminate',
    parentCheckbox: 'indeterminate',
    disabledCheckbox: 'on',
  });

  const countries = [
    'United States',
    'Canada',
    'United Kingdom',
    'Australia',
    'Germany',
    'France',
    'Mexico',
    'Iran',
    'Pakistan',
    'Vietnam',
    'Philippines',
    'Japan',
    'China',
    'India',
    'Russia',
    'Brazil',
  ];

  const handleChange = (name: string, value: string) => {
    setFormData({
      ...formData,
      [name]: value,
    });
  };

  const toggleCheckbox = checkboxName => {
    setCheckboxStates(prev => {
      const currentState = prev[checkboxName];
      let newState;

      if (currentState === 'on') newState = 'off';
      else if (currentState === 'off') newState = 'indeterminate';
      else newState = 'on';

      return {
        ...prev,
        [checkboxName]: newState,
      };
    });
  };

  const handleParentCheckboxPress = () => {
    setCheckboxStates(prev => {
      const currentState = prev.parentCheckbox;
      let newChildState;

      if (currentState === 'on') newChildState = 'off';
      else newChildState = 'on';

      return {
        ...prev,
        parentCheckbox: newChildState,
        checkbox1: newChildState,
        checkbox2: newChildState,
        checkbox3: newChildState,
      };
    });
  };

  const handleSubmit = () => {
    console.log('Form submitted:', formData);
    alert(
      `Form submitted!\nName: ${formData.name}\nEmail: ${formData.email}\nCountry: ${formData.country}`,
    );
  };

  return (
    <>
      <View style={styles.container}>
        <Text style={styles.title}>Registration Form</Text>

        <TextInput
          label="email"
          variant="outlined"
          style={styles.input}
          onChangeText={text => handleChange('email', text)}
        />

        <TextInput
          label="password"
          style={styles.input}
          onChangeText={text => handleChange('password', text)}
        />

        <View style={styles.pickerContainer}>
          <Text style={styles.label}>Country:</Text>
          <DropdownMenu
            label="Choose a country"
            selectedIndex={1}
            options={countries}
            style={{borderColor: 'red', borderRadius: 1}}
            onOptionSelected={index => {
              setFormData({
                ...formData,
                country: countries[index],
              });
            }}
          />
        </View>

        <View style={styles.demoSection}>
          <Text style={styles.sectionTitle}>TriStateCheckbox Demo</Text>

          <View style={styles.checkboxRow}>
            <Text>On State:</Text>
            <TriStateCheckbox
              state={checkboxStates.checkbox1}
              onPress={() => toggleCheckbox('checkbox1')}
            />
          </View>

          <View style={styles.checkboxRow}>
            <Text>Off State:</Text>
            <TriStateCheckbox
              state={checkboxStates.checkbox2}
              onPress={() => toggleCheckbox('checkbox2')}
            />
          </View>

          <View style={styles.checkboxRow}>
            <Text>Indeterminate State:</Text>
            <TriStateCheckbox
              state={checkboxStates.checkbox3}
              onPress={() => toggleCheckbox('checkbox3')}
            />
          </View>

          <View style={styles.checkboxRow}>
            <Text>Parent Checkbox:</Text>
            <TriStateCheckbox
              state={checkboxStates.parentCheckbox}
              onPress={handleParentCheckboxPress}
            />
          </View>

          <View style={styles.checkboxRow}>
            <Text>Disabled Checkbox:</Text>
            <TriStateCheckbox
              state={checkboxStates.disabledCheckbox}
              onPress={() => {}}
              disabled={true}
            />
          </View>
        </View>

        <Button title="Submit" onPress={handleSubmit} />
      </View>
      <BottomSheet style={$nativeSheet}>
        {/* <View */}
        {/*   collapsable={false} */}
        {/*   style={[ */}
        {/*     {flex: 1}, */}
        {/*     {overflow: Platform.select({ios: undefined, android: 'hidden'})}, */}
        {/*   ]}> */}
        {/* <ScrollView style={{flex: 1}} nestedScrollEnabled> */}
        <Text style={styles.title}>Registration Form</Text>

        {/* <FlatList */}
        {/*   data={countries} */}
        {/*   renderItem={({item}) => ( */}
        {/*     <Text style={[styles.input, {height: 100}]}>{item}</Text> */}
        {/*   )} */}
        {/*   keyExtractor={item => item} */}
        {/*   nestedScrollEnabled */}
        {/* /> */}

        <TextInput
          label="email"
          variant="outlined"
          style={styles.input}
          onChangeText={text => handleChange('email', text)}
        />

        <View style={styles.pickerContainer}>
          <Text style={styles.label}>Country:</Text>
          <DropdownMenu
            label="Choose a country"
            selectedIndex={1}
            options={countries}
            style={{borderColor: 'red', borderRadius: 1}}
            onOptionSelected={index => {
              setFormData({
                ...formData,
                country: countries[index],
              });
            }}
          />
        </View>

        <TextInput
          label="password"
          style={styles.input}
          onChangeText={text => handleChange('password', text)}
        />

        <Pressable
          style={{
            backgroundColor: 'red',
            height: 50,
            width: 100,
            alignItems: 'center',
            justifyContent: 'center',
          }}
          android_ripple={{
            color: 'black',
            radius: 10,
            borderless: false,
          }}
          onPress={() => {
            console.log('Pressed');
          }}>
          <Text>Press Me</Text>
        </Pressable>

        <TextInput
          label="password"
          style={styles.input}
          onChangeText={text => handleChange('password', text)}
        />
        <TextInput
          label="password"
          style={styles.input}
          onChangeText={text => handleChange('password', text)}
        />
        <TextInput
          label="password"
          style={styles.input}
          onChangeText={text => handleChange('password', text)}
        />
        <TextInput
          label="password"
          style={styles.input}
          onChangeText={text => handleChange('password', text)}
        />
        <TextInput
          label="password"
          style={styles.input}
          onChangeText={text => handleChange('password', text)}
        />
        <TextInput
          label="password"
          style={styles.input}
          onChangeText={text => handleChange('password', text)}
        />
        <Pressable
          style={{
            backgroundColor: 'red',
            height: 50,
            width: 100,
            alignItems: 'center',
            justifyContent: 'center',
          }}
          android_ripple={{
            color: 'black',
            radius: 10,
            borderless: false,
          }}
          onPress={() => {
            console.log('Pressed');
          }}>
          <Text>Press Me</Text>
        </Pressable>
        <TextInput
          label="password"
          style={styles.input}
          onChangeText={text => handleChange('password', text)}
        />
        <TextInput
          label="password"
          style={styles.input}
          onChangeText={text => handleChange('password', text)}
        />
        <TextInput
          label="password"
          style={styles.input}
          onChangeText={text => handleChange('password', text)}
        />
        <TextInput
          label="password"
          style={styles.input}
          onChangeText={text => handleChange('password', text)}
        />
        <TextInput
          label="password"
          style={styles.input}
          onChangeText={text => handleChange('password', text)}
        />
        <TextInput
          label="password"
          style={styles.input}
          onChangeText={text => handleChange('password', text)}
        />
        <TextInput
          label="password"
          style={styles.input}
          onChangeText={text => handleChange('password', text)}
        />
        <TextInput
          label="password"
          style={styles.input}
          onChangeText={text => handleChange('password', text)}
        />

        <TextInputRN
          style={styles.input}
          onChangeText={text => handleChange('password', text)}
        />
        {/* </ScrollView> */}
        {/* </View> */}
      </BottomSheet>
    </>
  );
}

const styles = StyleSheet.create({
  sheet: {
    flex: 1,
  },
  primary: {
    position: 'absolute',
    bottom: 0,
    width: '100%',
    justifyContent: 'flex-end',
  },
  bottomSheetContainer: {
    backgroundColor: 'gray',
    padding: 20,
  },
  container: {
    flex: 1,
    padding: 20,
    justifyContent: 'center',
  },
  dropdown: {
    height: 200,
  },
  title: {
    fontSize: 24,
    fontWeight: 'bold',
    marginBottom: 20,
    textAlign: 'center',
  },
  input: {
    borderColor: 'red',
    borderWidth: 1,
    marginBottom: 15,
    paddingHorizontal: 10,
    borderRadius: 5,
  },
  pickerContainer: {
    marginBottom: 20,
  },
  picker: {
    height: 50,
    width: '100%',
  },
  label: {
    marginBottom: 5,
    fontWeight: 'bold',
  },
  demoSection: {
    marginVertical: 20,
    padding: 10,
    borderWidth: 1,
    borderColor: '#ddd',
    borderRadius: 5,
  },
  sectionTitle: {
    fontSize: 18,
    fontWeight: 'bold',
    marginBottom: 10,
  },
  checkboxRow: {
    flexDirection: 'row',
    alignItems: 'center',
    justifyContent: 'space-between',
    marginVertical: 8,
  },
});

const $nativeSheet: ViewStyle = {
  flex: 1,
  position: 'absolute',
  width: '100%',
  height: '100%',
  // left: -9999,
  // zIndex: -9999,
};

export default App;
