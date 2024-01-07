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
  String selectedSection = 'Description'; // Default section

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
                      borderRadius: BorderRadius.circular(8.0),
                      child: Image.network(
                        beer.imageUrl,
                        fit: BoxFit.contain,
                        height: MediaQuery.of(context).size.height * 0.45,
                        width: double.infinity,
                      ),
                    ),
                    SizedBox(height: 16.0),
                    Text(
                      beer.name,
                      style: TextStyle(
                        fontWeight: FontWeight.bold,
                        fontSize: 20.0,
                      ),
                    ),
                    Text(
                      beer.tagline,
                      style: TextStyle(
                        fontStyle: FontStyle.italic,
                        color: Colors.grey,
                      ),
                    ),
                    SizedBox(height: 16.0),
                    Divider(height: 1.0, thickness: 1.0),
                    SizedBox(height: 16.0),
                    // Navigation
                    Row(
                      mainAxisAlignment: MainAxisAlignment.spaceEvenly,
                      children: [
                        InkWell(
                          onTap: () {
                            setState(() {
                              selectedSection = 'Description';
                            });
                          },
                          child: Text(
                            'Description',
                            style: TextStyle(
                              fontWeight: selectedSection == 'Description'
                                  ? FontWeight.bold
                                  : FontWeight.normal,
                              color: Colors.blue,
                            ),
                          ),
                        ),
                        InkWell(
                          onTap: () {
                            setState(() {
                              selectedSection = 'Specifications';
                            });
                          },
                          child: Text(
                            'Specifications',
                            style: TextStyle(
                              fontWeight: selectedSection == 'Specifications'
                                  ? FontWeight.bold
                                  : FontWeight.normal,
                              color: Colors.blue,
                            ),
                          ),
                        ),
                      ],
                    ),
                    SizedBox(height: 16.0),
                    // Content based on selected section
                    if (selectedSection == 'Description')
                      Text(
                        beer.description,
                        style: TextStyle(fontSize: 16.0),
                      )
                    else if (selectedSection == 'Specifications')
                      Column(
                        crossAxisAlignment: CrossAxisAlignment.start,
                        children: [
                          Text('ABV: ${beer.abv.toStringAsFixed(1)}%'),
                          Text('IBU: ${beer.ibu.toStringAsFixed(1)}'),
                          Text('Brewing Method: ${beer.brewingMethod}'),
                          SizedBox(height: 16.0),
                          Text('Ingredients: ${beer.ingredients.join(', ')}'),
                          SizedBox(height: 16.0),
                          Text('Food Pairing: ${beer.foodPairing.join(', ')}'),
                          SizedBox(height: 16.0),
                          Text('Brewer\'s Tips: ${beer.brewersTips}'),
                        ],
                      ),
                  ],
                ),
              ),
            );
          } else if (snapshot.hasError) {
            return Center(
              child: Text('Error: ${snapshot.error}'),
            );
          }

          return const Center(
            child: CircularProgressIndicator(),
          );
        },
      ),
    );
  }
}
