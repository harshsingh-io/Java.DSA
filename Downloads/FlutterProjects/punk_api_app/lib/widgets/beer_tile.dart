import 'package:flutter/material.dart';
import '../models/beer_model.dart';
import '../screens/beer_details_screen.dart';

class BeerTile extends StatelessWidget {
  final BeerModel beer;

  BeerTile({required this.beer});

  @override
  Widget build(BuildContext context) {
    return Column(
      children: [
        Padding(
          padding: const EdgeInsets.symmetric(
              horizontal: 16.0), // Add left and right padding
          child: ListTile(
            contentPadding: EdgeInsets.zero, // Remove default ListTile padding
            leading: ClipRRect(
              borderRadius: BorderRadius.circular(8.0),
              child: Image.network(
                beer.imageUrl,
                fit: BoxFit.contain,
                height: MediaQuery.of(context).size.height * 0.2,
                width: 80.0,
              ),
            ),
            title: Text(beer.name),
            subtitle: Text(
                'ABV: ${beer.abv.toStringAsFixed(1)}% | IBU: ${beer.ibu.toStringAsFixed(1)}'),
            onTap: () {
              Navigator.push(
                context,
                MaterialPageRoute(
                  builder: (context) => BeerDetailsScreen(beerId: beer.id),
                ),
              );
            },
          ),
        ),
        const Padding(
          padding: EdgeInsets.symmetric(
              horizontal: 16.0), // Add left and right padding
          child: Divider(
            height: 1.0, // Set the height of the divider
            color: Colors.grey, // Set the color of the divider
          ),
        ),
      ],
    );
  }
}
