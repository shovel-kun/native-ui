import React, {useState} from 'react';
import {Text, View, StyleSheet, Button} from 'react-native';
import {TextInput, DropdownMenu, TriStateCheckbox} from '@shovel-kun/native-ui';

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
    <View style={styles.container}>
      <Text style={styles.title}>Registration Form</Text>

      <TextInput
        label="email"
        variant="outlined"
        style={styles.input}
        onChangeText={{f: text => handleChange('email', text)}}
      />

      <TextInput
        label="password"
        style={styles.input}
        onChangeText={{f: text => handleChange('password', text)}}
      />

      <View style={styles.pickerContainer}>
        <Text style={styles.label}>Country:</Text>
        <DropdownMenu
          label="Choose a country"
          selectedIndex={1}
          options={countries}
          style={{borderColor: 'red', borderRadius: 1}}
          onOptionSelected={{
            f: index => {
              setFormData({
                ...formData,
                country: countries[index],
              });
            },
          }}
        />
      </View>

      {/* TriStateCheckbox Demo Section */}
      <View style={styles.demoSection}>
        <Text style={styles.sectionTitle}>TriStateCheckbox Demo</Text>

        <View style={styles.checkboxRow}>
          <Text>On State:</Text>
          <TriStateCheckbox
            state={checkboxStates.checkbox1}
            onPress={{f: () => toggleCheckbox('checkbox1')}}
          />
        </View>

        <View style={styles.checkboxRow}>
          <Text>Off State:</Text>
          <TriStateCheckbox
            state={checkboxStates.checkbox2}
            onPress={{f: () => toggleCheckbox('checkbox2')}}
          />
        </View>

        <View style={styles.checkboxRow}>
          <Text>Indeterminate State:</Text>
          <TriStateCheckbox
            state={checkboxStates.checkbox3}
            onPress={{f: () => toggleCheckbox('checkbox3')}}
          />
        </View>

        <View style={styles.checkboxRow}>
          <Text>Parent Checkbox:</Text>
          <TriStateCheckbox
            state={checkboxStates.parentCheckbox}
            onPress={{f: handleParentCheckboxPress}}
          />
        </View>

        <View style={styles.checkboxRow}>
          <Text>Disabled Checkbox:</Text>
          <TriStateCheckbox
            state={checkboxStates.disabledCheckbox}
            onPress={{f: () => {}}}
            disabled={true}
          />
        </View>
      </View>

      <Button title="Submit" onPress={handleSubmit} />
    </View>
  );
}

const styles = StyleSheet.create({
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

export default App;
