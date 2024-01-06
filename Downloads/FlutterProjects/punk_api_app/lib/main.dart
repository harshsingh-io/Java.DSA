// lib/main.dart
import 'package:flutter/material.dart';
import 'screens/beer_list_screen.dart';

void main() {
  runApp(MyApp());
}

class MyApp extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
  title: 'Flutter BLoC App with Punk API',
  theme: ThemeData(
    primarySwatch: Colors.blue,
  ),
  home: BeerListScreen(),
  // debugShowMaterialGrid: true, // Add this line
);
  }
}
