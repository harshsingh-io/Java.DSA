// lib/blocs/beer_list_bloc.dart
import 'dart:async';
import '../models/beer_model.dart';
import '../services/api_service.dart';

class BeerListBloc {
  final _apiService = ApiService();
  final _beerListController = StreamController<List<BeerModel>>.broadcast();

  Stream<List<BeerModel>> get beerListStream => _beerListController.stream;

  List<BeerModel> _currentBeerList = [];

  void fetchBeers() async {
    try {
      _currentBeerList = await _apiService.fetchBeers();
      _beerListController.add(_currentBeerList);
    } catch (e) {
      print('Error fetching beers: $e');
    }
  }
  
  void filterByABV(double minABV, double maxABV) {
    List<BeerModel> filteredList = _currentBeerList
        .where((beer) => beer.abv >= minABV && beer.abv <= maxABV)
        .toList();
    _beerListController.add(filteredList);
  }

  void filterByIBU(double minIBU, double maxIBU) {
    List<BeerModel> filteredList = _currentBeerList
        .where((beer) => beer.ibu >= minIBU && beer.ibu <= maxIBU)
        .toList();
    _beerListController.add(filteredList);
  }
  
  void dispose() {
    _beerListController.close();
  }
}

final beerListBloc = BeerListBloc();
