// lib/screens/beer_details_screen.dart
import 'package:flutter/material.dart';
import '../blocs/beer_details_bloc.dart';
import '../models/beer_model.dart';

class BeerDetailsScreen extends StatefulWidget {
  final int beerId;

  BeerDetailsScreen({required this.beerId});

  @override
  _BeerDetailsScreenState createState() => _BeerDetailsScreenState();
}

class _BeerDetailsScreenState extends State<BeerDetailsScreen> {
  @override
  void initState() {
    super.initState();
    beerDetailsBloc.fetchBeerDetails(widget.beerId);
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text('Beer Details'),
      ),
      body: StreamBuilder<BeerModel>(
        stream: beerDetailsBloc.beerDetailsStream,
        builder: (context, snapshot) {
          if (snapshot.hasData) {
            BeerModel beer = snapshot.data!;
            return SingleChildScrollView(
              child: Container(
                padding: EdgeInsets.all(16.0),
                child: Column(
                  crossAxisAlignment: CrossAxisAlignment.start,
                  children: [
                     ClipRRect(
                      borderRadius: BorderRadius.circular(8.0), // Adjust the radius as needed
                      child: Image.network(
                        beer.imageUrl,
                        height: 200.0,
                        width: double.infinity,
                        fit: BoxFit.cover,
                      ),
                    ),
                    SizedBox(height: 16.0),
                    Text('Name: ${beer.name}'),
                    Text('ABV: ${beer.abv.toStringAsFixed(1)}%'),
                    Text('IBU: ${beer.ibu.toStringAsFixed(1)}'),
                    // Add more details as needed
                  ],
                ),
              ),
            );
          } else if (snapshot.hasError) {
            return Center(
              child: Text('Error: ${snapshot.error}'),
            );
          }

          // Loading indicator
          return Center(
            child: CircularProgressIndicator(),
          );
        },
      ),
    );
  }
}
