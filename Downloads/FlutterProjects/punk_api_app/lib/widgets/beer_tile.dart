import 'package:flutter/material.dart';
import '../models/beer_model.dart';
import '../screens/beer_details_screen.dart';

class BeerTile extends StatelessWidget {
  final BeerModel beer;

  BeerTile({required this.beer});

  @override
  Widget build(BuildContext context) {
    return ListTile(
      leading: CircleAvatar(
        backgroundImage: NetworkImage(beer.imageUrl),
      ),
      title: Text(beer.name),
      subtitle: Text('ABV: ${beer.abv.toStringAsFixed(1)}% | IBU: ${beer.ibu.toStringAsFixed(1)}'),
      onTap: () {
        Navigator.push(
          context,
          MaterialPageRoute(
            builder: (context) => BeerDetailsScreen(beerId: beer.id),
          ),
        );
      },
    );
  }
}