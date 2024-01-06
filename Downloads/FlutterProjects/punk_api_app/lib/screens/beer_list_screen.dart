// lib/screens/beer_list_screen.dart
import 'package:flutter/material.dart';
import '../blocs/beer_list_bloc.dart';
import '../models/beer_model.dart';
import '../widgets/beer_tile.dart';

class BeerListScreen extends StatefulWidget {
  @override
  _BeerListScreenState createState() => _BeerListScreenState();
}

class _BeerListScreenState extends State<BeerListScreen> {
  @override
  void initState() {
    super.initState();
    beerListBloc.fetchBeers();
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text('Beer List'),
      ),
      body: StreamBuilder<List<BeerModel>>(
        stream: beerListBloc.beerListStream,
        builder: (context, snapshot) {
          if (snapshot.hasData) {
            List<BeerModel> beers = snapshot.data!;
            return ListView.builder(
              itemCount: beers.length,
              itemBuilder: (context, index) {
                return BeerTile(beer: beers[index]);
              },
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
