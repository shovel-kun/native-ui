import React, {useState} from 'react';
import {Text, View, StyleSheet, Button} from 'react-native';
import {TextInput, DropdownMenu} from '@shovel-kun/native-ui';

function App(): React.JSX.Element {
  const [formData, setFormData] = useState({
    name: '',
    email: '',
    country: '',
    password: '',
  });

  const countries = ['United States', 'Canada', 'United Kingdom', 'Australia'];

  const handleChange = (name: string, value: string) => {
    setFormData({
      ...formData,
      [name]: value,
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
        label="name"
        style={styles.input}
        onValueChange={{f: text => handleChange('name', text)}}
      />

      <TextInput
        label="email"
        style={styles.input}
        onValueChange={{f: text => handleChange('email', text)}}
      />

      <TextInput
        label="password"
        style={styles.input}
        onValueChange={{f: text => handleChange('password', text)}}
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

      <Button title="Submit" onPress={handleSubmit} />
    </View>
  );

  // return (
  //   <View style={styles.container}>
  //     <TextInput placeholder="meow" label={'hi'} />
  //     <DropdownMenu
  //       //style={styles.dropdown}
  //       options={['hello', 'world']}
  //       onOptionSelected={{
  //         f: option => {
  //           console.log(option);
  //         },
  //       }}
  //     />
  //   </View>
  // );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    padding: 20,
    justifyContent: 'center',
  },
  view: {
    width: 200,
    height: 200,
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
});

export default App;
