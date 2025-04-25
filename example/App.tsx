import React from 'react';
import {Text, View, StyleSheet} from 'react-native';
import {TextInput} from '@shovel-kun/native-ui';

function App(): React.JSX.Element {
  return (
    <View style={styles.container}>
      <TextInput label={'hi'} />
    </View>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    justifyContent: 'center',
    alignItems: 'center',
  },
  view: {
    width: 200,
    height: 200,
  },
});

export default App;
